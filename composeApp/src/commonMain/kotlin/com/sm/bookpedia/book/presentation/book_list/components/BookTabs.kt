package com.sm.bookpedia.book.presentation.book_list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.favorites
import cmp_bookpedia.composeapp.generated.resources.search_results
import com.sm.bookpedia.core.presentation.DesertWhite
import com.sm.bookpedia.core.presentation.SandYellow

@Composable
fun BookTabs(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    selectedContentColor: Color,
    unselectedContentColor: Color
) {
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = DesertWhite,
        indicator = { tabPositions ->
            TabRowDefaults.SecondaryIndicator(
                color = SandYellow,
                modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
            )
        }
    ) {
        CustomTab(
            isSelected = selectedTabIndex==1,
            onTabSelected = { onTabSelected(1) },
            selectedContentColor = selectedContentColor,
            unselectedContentColor = unselectedContentColor,
            text = stringResource(Res.string.search_results)
        )
        CustomTab(

            isSelected = selectedTabIndex==1,
            onTabSelected = { onTabSelected(1) },
            selectedContentColor = selectedContentColor,
            unselectedContentColor = unselectedContentColor,
            text = stringResource(Res.string.favorites)
        )
    }
}

@Composable
fun CustomTab(
    isSelected: Boolean ,
    onTabSelected: () -> Unit,
    selectedContentColor: Color,
    unselectedContentColor: Color,
    text: String,
    modifier: Modifier = Modifier
) {
    Tab(
        selected =isSelected,
        onClick = { onTabSelected() },
        selectedContentColor = selectedContentColor,
        unselectedContentColor = unselectedContentColor,
        modifier = modifier
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 12.dp)
        )
    }
}
