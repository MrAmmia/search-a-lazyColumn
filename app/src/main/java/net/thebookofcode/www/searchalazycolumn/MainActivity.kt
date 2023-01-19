package net.thebookofcode.www.searchalazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import net.thebookofcode.www.searchalazycolumn.ui.theme.SearchALazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchALazyColumnTheme {
                val repository = PersonRepository()
                val allData = repository.getAllData()
                val textState = remember { mutableStateOf(TextFieldValue("")) }
                Column {
                    TopBar()
                    SearchView(state = textState)
                    PersonList(people = allData, state = textState)
                }
            }
        }
    }
}

