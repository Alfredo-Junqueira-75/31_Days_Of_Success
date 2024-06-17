package com.junqueira.a31daysofsucess

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.junqueira.a31daysofsucess.data.DailyQuote
import com.junqueira.a31daysofsucess.data.DataSource.dailyQuotes
import com.junqueira.a31daysofsucess.ui.theme._31DaysOfSucessTheme


@Composable
fun QuoteCard(dailyQuote: DailyQuote, modifier: Modifier = Modifier) {
    var hidden by remember { mutableStateOf(true) }
    val enterTransition = remember {
        expandVertically(
            expandFrom = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeIn(animationSpec = tween(300))
    }
    val exitTransition = remember{
        shrinkVertically(
            shrinkTowards = Alignment.Top,
            animationSpec = tween(300)
        ) + fadeOut(animationSpec = tween(300))
    }

    ElevatedCard(
        elevation  = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        onClick = { hidden = !hidden },
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = dailyQuote.dayNumberRes, dailyQuotes.indexOf(dailyQuote).plus(1)),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = stringResource(id = dailyQuote.titleRes),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
            )
            Image(painter = painterResource(id = dailyQuote.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .size(280.dp)
            )
            AnimatedVisibility(
                visible = !hidden,
                enter = enterTransition,
                exit = exitTransition
            ) {
                Text(
                    text = stringResource(id = dailyQuote.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}


@Composable
fun QuoteCardPreview(modifier: Modifier = Modifier) {
    _31DaysOfSucessTheme {
        QuoteCard(dailyQuotes[11])
    }
}

@Composable
fun QuoteCardList(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(dailyQuotes.size) {
            QuoteCard(
                dailyQuotes[it],
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun QuoteCardListPreview(modifier: Modifier = Modifier) {
    _31DaysOfSucessTheme {
        QuoteCardList()
    }
}