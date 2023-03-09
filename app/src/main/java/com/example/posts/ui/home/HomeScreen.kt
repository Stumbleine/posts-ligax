package com.example.posts.ui.home


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.posts.data.Result
import com.example.posts.domain.model.Post
import kotlinx.coroutines.flow.collectLatest


@Composable
fun HomeScreen(
    onItemClicked: (Int) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()

) {
    val state = viewModel.state
    val eventFlow = viewModel.eventFlow
    val scaffoldState = rememberScaffoldState()
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

    Scaffold(
        scaffoldState = scaffoldState,

        ) { innerPadding ->
        HomeContent(
            modifier = Modifier.padding(innerPadding),
            onItemClicked = { onItemClicked(it) },
            isLoading = state.isLoading,
            posts = state.posts

        )
    }

    /*
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Olvidaste la contraseña?",
            color = Color.Red
        )
    }
    */

}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit,
    isLoading: Boolean = false,
    posts: List<Post> = emptyList()
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.surface
    ) {
        LazyColumn(
            contentPadding = PaddingValues(vertical = 5.dp),
            modifier = Modifier.fillMaxSize(),
            content = {
                items(posts.size) { index ->
                    Text(text = posts[index].title)

                }
            }

        )

    }
}


/*
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Retrofit retrofit= new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        ApiInterface apiInterface= retrofit.create(ApiInterface.class);

        Call<Post> call= apiInterface.getPost();

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                Log.i("response_title",response.body().getTitle()+"");
                Log.i("response_userId",response.body().getUserId()+"");
                Log.i("response_id",response.body().getId()+"");
                Log.i("response_body",response.body().getBody()+"");
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            }

        });
    }

    public interface ApiInterface {

        @GET("Posts/1")
        Call<Post> getPost();
    }

    public class Post {

        private int id;
        private int userId;
        private String title;
        private String body;

        public int getId() {
            return id;
        }

        public int getUserId() {
            return userId;
        }

        public String getTitle() {
            return title;
        }

        public String getBody() {
            return body;
        }
    }

 */