package com.hapkiduki.movies.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hapkiduki.movies.presentation.ui.theme.Black
import com.hapkiduki.movies.presentation.ui.theme.BlueDark
import androidx.hilt.navigation.compose.hiltViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    val gradient = Brush.linearGradient(
        listOf(
            Black, BlueDark
        )
    )

    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .background(gradient)
            .padding(top = 36.dp)

    )
    { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(state.movies) {
                Text(
                    text = it.title,
                    color = Color.White
                )
            }

        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)

            )
        }
        if (state.isLoading) {

            CircularProgressIndicator(
                modifier = Modi
            )
        }
    }
}

@Preview
@Composable
fun HomePReview() {

    HomePage()
}

