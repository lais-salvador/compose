package com.example.ejercicio_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Exercise1() {
    Box(
        modifier = Modifier
            .size(250.dp)
            .background(Color.Green)
    ){
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red)
                .align(Alignment.Center)
        ){
            Box(modifier = Modifier
                .size(40.dp)
                .background(Color.White)
            ){}

            Box(modifier = Modifier
                .size(60.dp)
                .background(Color.Blue)
                .align(Alignment.CenterEnd)
            ){}
        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Black)
                .align(Alignment.BottomStart)
        ){}

        Box(
            modifier = Modifier
                .width(50.dp)
                .height(220.dp)
                .background(Color.Gray)
                .align(Alignment.Center)
        ){}

    }
}

@Composable
fun Exercise2() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            createBox(20.dp,20.dp, Color.Blue)
            createBox(40.dp,40.dp, Color.Red)
            createBox(60.dp,60.dp, Color.Yellow)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            createBox(20.dp,20.dp, Color.Blue)
            createBox(40.dp,40.dp, Color.Red)
            createBox(60.dp,60.dp, Color.Yellow)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            createBox(40.dp,40.dp, Color.Green)
            createBox(40.dp,40.dp, Color.Cyan)
            createBox(40.dp,40.dp, Color.Black)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            createBox(40.dp,40.dp, Color.Green, Modifier.weight(1f))
            createBox(40.dp,40.dp, Color.Cyan, Modifier.weight(1f))
            createBox(40.dp,40.dp, Color.Black, Modifier.weight(1f))
        }
    }
}

@Composable
fun createBox(w: Dp, h: Dp, color: Color, mod: Modifier = Modifier){
    Box(
        mod
            .background(color)
            .width(w)
            .height(h)
    ){}
}