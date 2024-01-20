package eu.tutorial.refundapp

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TopBar(
    title:String,
    onBackNavClicked:()-> Unit={}){
    TopAppBar(title = { Text(text = title)},
        modifier = Modifier.padding(start = 4.dp).heightIn(max= 24.dp))
}

