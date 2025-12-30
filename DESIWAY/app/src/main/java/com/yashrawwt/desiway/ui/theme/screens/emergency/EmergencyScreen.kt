package com.yashrawwt.desiway.ui.theme.screens.emergency

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.provider.ContactsContract
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.yashrawwt.desiway.ui.theme.MustardBottom
import com.yashrawwt.desiway.ui.theme.MustardTop

/* ---------------- DATA MODEL ---------------- */

data class EmergencyContact(
    val name: String,
    val number: String,
    val photoUri: String?
)

/* ---------------- SCREEN ---------------- */

@Composable
fun EmergencyScreen() {

    val context = LocalContext.current
    val emergencyContacts = remember { mutableStateListOf<EmergencyContact>() }

    /* ---------- CONTACT PICKER ---------- */

    val contactPickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    val cursor = context.contentResolver.query(
                        uri,
                        arrayOf(
                            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                            ContactsContract.CommonDataKinds.Phone.NUMBER,
                            ContactsContract.CommonDataKinds.Phone.PHOTO_URI
                        ),
                        null,
                        null,
                        null
                    )

                    cursor?.use {
                        if (it.moveToFirst()) {
                            val name = it.getString(0)
                            val number = it.getString(1)
                            val photo = it.getString(2)

                            if (emergencyContacts.none { c -> c.number == number }) {
                                emergencyContacts.add(
                                    EmergencyContact(
                                        name = name,
                                        number = number,
                                        photoUri = photo
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }

    val permissionLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                contactPickerLauncher.launch(
                    Intent(
                        Intent.ACTION_PICK,
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                    )
                )
            }
        }

    /* ---------- UI ---------- */

    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(listOf(MustardTop, MustardBottom))
                )
                .padding(padding)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                item { EmergencyHeader() }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        EmergencyCard(
                            modifier = Modifier.weight(1f),
                            image = "https://media.assettype.com/psuwatch%2Fimport%2Fwp-content%2Fuploads%2F2022%2F02%2F2147267006_5fc8ac9eb0239.jpg",
                            title = "POLICE STATION",
                            subtitle = "CALL 100"
                        )
                        EmergencyCard(
                            modifier = Modifier.weight(1f),
                            image = "https://amcarehospital.com/wp-content/uploads/2023/12/Are-Hospitals-Making-as-Much-Money-as-You-Think1.jpg",
                            title = "HOSPITAL",
                            subtitle = "CALL 108"
                        )
                    }
                }

                item { SOSButton() }

                item {
                    EmergencyContactsSection(
                        contacts = emergencyContacts,
                        onAddClick = {
                            permissionLauncher.launch(Manifest.permission.READ_CONTACTS)
                        }
                    )
                }

                item { Spacer(Modifier.height(40.dp)) }
            }
        }
    }
}

/* ---------------- HEADER ---------------- */

@Composable
private fun EmergencyHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Emergency", style = MaterialTheme.typography.headlineMedium)
            Text("DESI WAY", style = MaterialTheme.typography.labelMedium)
            Spacer(Modifier.height(8.dp))
            Text("Doesn’t feel safe or need help", fontWeight = FontWeight.SemiBold)
            Text("CALL 112", fontWeight = FontWeight.SemiBold)
        }

        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text("U", fontWeight = FontWeight.Bold)
        }
    }
}

/* ---------------- EMERGENCY CARD ---------------- */

@Composable
private fun EmergencyCard(
    modifier: Modifier,
    image: String,
    title: String,
    subtitle: String
) {
    Box(
        modifier = modifier
            .height(160.dp)
            .clip(RoundedCornerShape(18.dp))
    ) {
        AsyncImage(
            model = image,
            contentDescription = title,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Color.Black.copy(alpha = 0.55f))
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Text(title, color = Color.White, fontWeight = FontWeight.Bold)
            Text(subtitle, color = Color.White)
        }
    }
}

/* ---------------- SOS ---------------- */

@Composable
private fun SOSButton() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .background(Color.Red, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("SOS", color = Color.White, style = MaterialTheme.typography.headlineMedium)
        }
    }
}

/* ---------------- CONTACTS ---------------- */

@Composable
private fun EmergencyContactsSection(
    contacts: List<EmergencyContact>,
    onAddClick: () -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 20.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Emergency Contacts", fontWeight = FontWeight.Bold)
            IconButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

        Spacer(Modifier.height(12.dp))

        contacts.forEach { contact ->
            Row(
                modifier = Modifier.padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                ContactAvatar(contact.name, contact.photoUri)

                Spacer(Modifier.width(12.dp))

                Column {
                    Text(contact.name, fontWeight = FontWeight.Medium)
                    Text(contact.number, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

/* ---------------- AVATAR ---------------- */

@Composable
private fun ContactAvatar(
    name: String,
    photoUri: String?
) {
    if (photoUri != null) {
        AsyncImage(
            model = photoUri,
            contentDescription = name,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    } else {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color(0xFFE0E0E0)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name.firstOrNull()?.uppercase() ?: "?",
                fontWeight = FontWeight.Bold
            )
        }
    }
}
