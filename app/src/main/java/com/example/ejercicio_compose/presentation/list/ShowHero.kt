package com.example.ejercicio_compose.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ejercicio_compose.domain.model.HeroModel
import com.example.ejercicio_compose.domain.model.TestDataBuilder

@Composable
fun ShowHero(
    hero: HeroModel,
    onClick: (() -> Unit)? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color.White)
            .padding(10.dp)
            .clickable { onClick?.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Img(hero.photoUrl)
            Spacer(modifier = Modifier.width(10.dp))
            Column(
            ) {
                Name(hero.name)
                Spacer(modifier = Modifier.height(8.dp))
                Description(hero.description)
            }
        }
    }
}

@Composable
fun Img(photoUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(photoUrl)
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = Modifier.size(130.dp)
            .background(Color.Gray),
    )
}

@Composable
fun Name(name: String){
    Text(
        text = name,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 1.sp
    )
}

@Composable
fun Description(description: String){
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = description,
        fontSize = 10.sp,
        maxLines = 4,
        lineHeight = 15.sp,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Justify,
    )
}

@Composable
@Preview
fun ShowHeroPreview(){
    ShowHero(
        TestDataBuilder()
        .withName("Lorem ipsum")
        .withDescription("At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus,")
        .withPhotoUrl("https://definicion.de/wp-content/uploads/2009/09/heroe-1.png")
        .buildSingle(),
        {}
    )
}