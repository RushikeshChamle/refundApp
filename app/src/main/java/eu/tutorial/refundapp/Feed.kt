package eu.tutorial.refundapp
import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

data class Product(
    val productName: String,
    val price: Double,
    val date: Date,
    val status: String
)

@Composable
fun ProductListItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = product.productName,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = NumberFormat.getCurrencyInstance().format(product.price),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(product.date),
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = product.status,
            style = MaterialTheme.typography.bodySmall,
            color = when (product.status) {
                "Available" -> colorResource(id = R.color.holo_green_dark)
                "Out of Stock" -> colorResource(id = R.color.holo_red_dark)
                else -> MaterialTheme.colorScheme.onSurface
            }
        )
    }
}

@Composable
fun ProductList(products: List<Product>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Text(
            text = "Purchase Items",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(products) { product ->
                ProductListItem(product = product)
            }
        }
    }
}



@Composable
fun PurchaseItemsScreen() {
    // You can replace this with the actual content for the purchase items screen
    val products = getSampleProducts()
    ProductList(products = products)
}

fun getSampleProducts(): List<Product> {
    return listOf(
        Product("Product 1", 29.99, Date(), "Available"),
        Product("Product 2", 49.99, Date(), "Out of Stock"),
        Product("Product 3", 19.99, Date(), "Available"),
        Product("Product 4", 99.99, Date(), "Available"),
        Product("Product 5", 39.99, Date(), "Out of Stock"),
        Product("Product 6", 79.99, Date(), "Available"),
        Product("Product 7", 59.99, Date(), "Available"),
        Product("Product 8", 119.99, Date(), "Out of Stock")
    )
}




//
//@Preview(showBackground = true)
//@Composable
//fun ProductListPreview() {
//    val products = listOf(
//        Product("Product 1", 29.99, Date(), "Available"),
//        Product("Product 2", 49.99, Date(), "Out of Stock"),
//        Product("Product 3", 19.99, Date(), "Available"),
//        Product("Product 4", 99.99, Date(), "Available"),
//        Product("Product 1", 29.99, Date(), "Available"),
//        Product("Product 2", 49.99, Date(), "Out of Stock"),
//        Product("Product 3", 19.99, Date(), "Available"),
//        Product("Product 4", 99.99, Date(), "Available")
//    )
//
//    ProductList(products = products)
//}
