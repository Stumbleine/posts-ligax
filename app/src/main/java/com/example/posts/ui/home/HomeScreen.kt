package com.example.posts.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.posts.domain.model.Post
import com.example.posts.ui.components.TopBar
import com.example.posts.ui.home.components.PostCard
import com.example.posts.ui.theme.myTheme
import kotlinx.coroutines.launch
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.posts.domain.model.FavoritePost

@Composable
fun HomeScreen(
    onItemClicked: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController,
) {

    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()
    val tabSelected:Int by viewModel.tabSelected.observeAsState(initial = 0)
/*
    LaunchedEffect(key1 = true ){
        eventFlow.collectLatest { event ->
            when (event){
                is HomeViewModel.UIEvent.showSnackBar ->{
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }
*/


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
                title = "Zamoga", navController = navController,
                openMenu = { openMenu() }
            )
        },
        drawerContent = {
            Text(
                "Drawer title",
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

                // containerColor = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(16.dp),
                backgroundColor = MaterialTheme.myTheme.error
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
            isLoading = state.isLoading,
            posts = state.posts,
            tabSelected = tabSelected,
            setTab = { viewModel.setTab(it) },
            favorites = state.favorites,
            viewModel = viewModel
        )
    }
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
    isLoading: Boolean = false,
    posts: List<FavoritePost> = emptyList(),
    favorites:List<FavoritePost> = emptyList(),
    tabSelected: Int,
    setTab: (Int) -> Unit,
    viewModel: HomeViewModel
) {
    val titles = listOf("ALL", "FAVORITES")

    Surface(
        modifier = modifier.fillMaxSize(),
    ) {

        Column() {
            TabRow(
                selectedTabIndex = tabSelected,
                backgroundColor = MaterialTheme.myTheme.primary
            ) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title, color = Color.White) },
                        selected = tabSelected == index,
                        onClick = { setTab(index) },
                        selectedContentColor = Color(0xFF12ea1d),
                    )
                }
            }
            if (tabSelected == 0) {
                LazyColumn(
                    contentPadding = PaddingValues(
                        vertical = 5.dp
                    ),
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        items(posts.size) { index ->
                            //Text(text = posts[index].title)
                            PostCard(
                                post = posts[index],
                                onItemClicked = { onItemClicked(it) },
                                viewModel=viewModel

                            )
                        }
                    }

                )
            }
            if(tabSelected==1){
                LazyColumn(
                    contentPadding = PaddingValues(
                        vertical = 5.dp
                    ),
                    modifier = Modifier.fillMaxSize(),
                    content = {
                        items(favorites.size) { index ->
                            Text(text = "hello")
                            PostCard(
                                post = posts[index],
                                onItemClicked = { onItemClicked(it) },
                                viewModel=viewModel
                            )
                        }
                    }

                )
            }
        }
    }
}

