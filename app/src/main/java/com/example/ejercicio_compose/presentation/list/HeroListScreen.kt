package com.example.ejercicio_compose.presentation.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ejercicio_compose.domain.model.TestDataBuilder

@Composable
fun HeroListScreen(
    //heroListViewModel: HeroListViewModel = koinViewModel()
    onItemClick: (String) -> Unit
){
    val heroList = TestDataBuilder()
        .withNumElements(10)
        .withName("Lorem ipsum")
        .withDescription("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus,")
        .withPhotoUrl("https://definicion.de/wp-content/uploads/2009/09/heroe-1.png")
        .build()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(heroList.size) { index ->
            val hero = heroList[index]
            ShowHero(hero = hero){
                onItemClick.invoke(hero.id)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun heroListPreview(){
    HeroListScreen({})
}