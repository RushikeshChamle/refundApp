import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDefaults.color
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // First ElevatedCard
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = Modifier
                .size(width = 400.dp, height = 120.dp)
                .offset(x = 0.dp, y = 90.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFF577BE7))
            ) {
                // Content of the first ElevatedCard
                Column {
                    Text(
                        text = "Total Refund",
                        modifier = Modifier.padding(16.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp,
                        color = Color.White
                    )

                    // Refund Amount
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = "INR ___",
                            modifier = Modifier.padding(16.dp),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                            fontSize = 26.sp,
                            color = Color.White
                        )
                    }
                }
                
                
                
            }
        }

        // Second and Third OutlinedCards aligned side by side
        Row(
            modifier = Modifier
                .fillMaxWidth() // Ensure the Row takes the full width
                .padding(top = 160.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .size(width = 190.dp, height = 100.dp)
            ) {
                Text(
                    text = "Refunded",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }

            OutlinedCard(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                border = BorderStroke(1.dp, Color.Black),
                modifier = Modifier
                    .size(width = 190.dp, height = 100.dp)
            ) {
                Text(
                    text = "In Progress",
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center,
                )
            }
        }
        
        Box {
            Column(modifier = Modifier
                .fillMaxSize()
                .offset(x = 10.dp, y = 20.dp)


                ) {
                Text(text = "Acvities")


            }
            LazyColumn(){

            }
        }
    }

   








}





@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
