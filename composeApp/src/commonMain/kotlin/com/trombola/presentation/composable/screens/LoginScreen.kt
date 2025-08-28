package com.trombola.presentation.composable.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.trombola.presentation.composable.elements.buttons.LoginButton
import com.trombola.presentation.composable.elements.textFields.PasswordTextField
import com.trombola.presentation.composable.elements.textFields.UsernameTextField
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import trombola.composeapp.generated.resources.Res
import trombola.composeapp.generated.resources.login_selector_account
import trombola.composeapp.generated.resources.login_selector_guest
import trombola.composeapp.generated.resources.trombola_logo_text

@Composable
fun LoginScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Image(
            painterResource(Res.drawable.trombola_logo_text),
            contentDescription = "trombola_logo"
        )
        Spacer(modifier = Modifier.size(30.dp))

        PagerSelector()

    }
}

@Composable
fun PagerSelector() {

    val pagerState = rememberPagerState(initialPage = 0) {
        2
    }
    var selectedTab by remember {
        mutableIntStateOf(pagerState.currentPage)
    }

    /* This links the pages to the tabs and the tabs to the pages:
     * when a tab is pressed, the page changes and when the user
     * swipe from a page to the other the tab is changed. */
    LaunchedEffect(selectedTab) {
        pagerState.scrollToPage(selectedTab)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectedTab = pagerState.currentPage
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.Transparent,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTab]),
                    color = Color.White
                )
            },
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {

            val tabText = arrayOf(
                Res.string.login_selector_guest,
                Res.string.login_selector_account
            )

            for (index in 0 until pagerState.pageCount) {
                Tab(
                    selected = index == selectedTab,
                    onClick = {
                        selectedTab = index
                    },
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(vertical = 5.dp)
                ) {
                    Text(
                        text = stringResource(tabText[index]),
                        color = Color.White
                    )
                }
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) { currentPage ->
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    when (currentPage) {
                        0 -> PlayAsGuest()
                        1 -> Login()
                    }
                }
            }
        }
    }
}

@Composable
fun Login() {
    UsernameTextField()
    PasswordTextField()
    Spacer(modifier = Modifier.size(30.dp))
    LoginButton()
}

@Composable
fun PlayAsGuest() {
    UsernameTextField()
    Spacer(modifier = Modifier.size(30.dp))
    LoginButton()
}