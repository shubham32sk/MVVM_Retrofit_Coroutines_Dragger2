package com.example.mvvmimplement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmimplement.Models.RecipeXItem
import com.example.mvvmimplement.ViewModels.ViewModel
import com.example.mvvmimplement.ViewModels.viewModelFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    lateinit var viewModel : ViewModel


    @Inject
    lateinit var viewModelFactory: viewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        (application as FakerApplication).ApplicationComponent.inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory).get(ViewModel::class.java)






        setContent {
            App(viewModel = viewModel)
        }
    }


}

@Composable
fun App(viewModel: ViewModel) {

    val data by viewModel.datalivedata.collectAsState(emptyList())
    UserList(data)

}



@Composable
fun UserList(users: List<RecipeXItem>) {
    LazyColumn() {
        items(users) { user ->
            UserItem(user)
        }
    }
}
@Composable
fun UserItem(user: RecipeXItem) {
    Column {
        Card( modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)


            .padding(16.dp),
            border = BorderStroke(2.dp, Color(0xFFCCCCCC)),
            content = {
                Text(text = "ID: ${user.id}",
                    color = Color.Black,
                    modifier =Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(5.dp)
                    ,
                    style = MaterialTheme.typography.bodyMedium)
                Text(text = "Title: ${user.title}",
                    color = Color.Black,
                    modifier =Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(5.dp)
                    ,
                    style = MaterialTheme.typography.bodyMedium)
                Text(text = "Price: ${user.price}",
                    color = Color.Black,
                    modifier =Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(5.dp)
                    ,
                    style = MaterialTheme.typography.bodyMedium)
            }
        )


    }
}


