package com.example.posts.ui.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.posts.domain.model.FavoritePost
import com.example.posts.ui.home.HomeViewModel
import com.example.posts.ui.theme.myTheme

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
    posts: List<FavoritePost> = emptyList(),
    favorites: List<FavoritePost> = emptyList(),
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
                            PostCard(
                                post = posts[index],
                                onItemClicked = { onItemClicked(it) },
                                viewModel = viewModel
                            )
                        }
                    }

                )
            }
            if (tabSelected == 1) {
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
                                viewModel = viewModel
                            )
                        }
                    }

                )
            }
        }
    }
}