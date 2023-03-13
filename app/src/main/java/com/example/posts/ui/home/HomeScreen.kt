package com.example.posts.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.posts.ui.components.TopBar
import kotlinx.coroutines.launch
import androidx.compose.runtime.livedata.observeAsState
import com.example.posts.ui.home.components.HomeContent
import com.example.posts.ui.theme.myTheme

@Composable
fun HomeScreen(
    onItemClicked: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {

    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()
    val tabSelected: Int by viewModel.tabSelected.observeAsState(initial = 0)
    val scope = rememberCoroutineScope()

    fun openMenu() {
        scope.launch {
            scaffoldState.drawerState.apply {
                if (isClosed) open() else close()
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = "Zemoga", navController = navController,
                openMenu = { openMenu() }
            )
        },
        drawerContent = {
            Text(
                "ZemogaApp",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.myTheme.textPrimary
            )
            Divider()
            Row(
                Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp),

                ) {
                Text(text = "Dark mode", color = MaterialTheme.myTheme.textPrimary)
                Switch(
                    checked = true, onCheckedChange = {},
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.myTheme.primary,
                        uncheckedThumbColor = MaterialTheme.myTheme.primaryVariant,
                    )
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.deleteAllPost()
                },
                shape = RoundedCornerShape(16.dp),
                backgroundColor =MaterialTheme.myTheme.error
            ) {
                Icon(
                    imageVector = Icons.Rounded.Delete,
                    contentDescription = "Add FAB",
                    tint = Color.White,
                )
            }
        }
    ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onItemClicked = { onItemClicked(it) },
            posts = state.posts,
            tabSelected = tabSelected,
            setTab = { viewModel.setTab(it) },
            favorites = state.favorites,
            viewModel = viewModel
        )
    }
}
