package eu.tutorial.refundapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf


import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)

data class BottomNavigationItem(
    val title:String,
    val selctedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val isNew :Boolean,
    val batch: Int?= null


)





@Composable

//Bottom Navbar

fun BottomNav() {
    var presses by remember { mutableIntStateOf(0) }

    //used to maintain state if selected Icon
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }


    val items = listOf(BottomNavigationItem(
        title = "Home",
        selctedIcon = Icons.Rounded.Home,
        unselectedIcon = Icons.Outlined.Home,
        isNew= false


    ),
        BottomNavigationItem(
            title = "Purchase",
            selctedIcon = Icons.Rounded.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
            isNew= false


        ),
        BottomNavigationItem(
            title = "Notification",
            selctedIcon = Icons.Rounded.Notifications,
            unselectedIcon = Icons.Outlined.Notifications,
            isNew= false


        ),
        BottomNavigationItem(
            title = "Profile",
            selctedIcon = Icons.Rounded.Person,
            unselectedIcon = Icons.Outlined.Person,
            isNew= false

        )

        )


    Scaffold(

        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(selected = selectedIndex ==index,
                        onClick = {
                                  selectedIndex = index
//                            navController.navigate(item.title)


                                  },


                        label = {
                                Text(text = item.title)

                        },
                        
                        icon = {
                            BadgedBox(badge = {
                                if (item.batch != null){
                                    Badge {
                                        Text(text = item.batch.toString())
                                    }

                                }
                                else if (item.isNew){
                                    Badge()
                                }



                            }) {
                                Icon(
                                    imageVector = if (index == selectedIndex) {
                                                                              item.selctedIcon

                                    }else item.unselectedIcon

                                    , contentDescription =""
                                )





                            }


                        })


                }






            }
        },

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        )
        {

        }
    }
}