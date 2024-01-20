package eu.tutorial.refundapp


import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@Composable
fun NotificationListItem(notification: Notification) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.surface)
            .clickable { /* Handle item click if needed */ }
    ) {
        Text(
            text = notification.title,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = notification.message,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(notification.date),
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}

@Composable
fun NotificationList(notifications: List<Notification>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Text(
            text = "Notifications",
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn {
            items(notifications) { notification ->
                NotificationListItem(notification = notification)
            }
        }
    }
}


data class Notification(
    val title: String,
    val message: String,
    val date: Date
)

fun getSampleNotifications(): List<Notification> {

    return listOf(
        Notification("New Message", "You have a new message", Date()),
        Notification("Reminder", "Don't forget your appointment", Date()),
        Notification("Offer", "Special discount for you", Date()),
        Notification("Alert", "Emergency alert", Date())
    )
}


@Composable
fun NotificationMainScreen(){
    val notifications = getSampleNotifications()

    NotificationList(notifications = notifications)
}



@Preview
@Composable

fun NotificationListPreview() {
    val notifications = getSampleNotifications()

    NotificationList(notifications = notifications)
}

