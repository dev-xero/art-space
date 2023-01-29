package dev.codeninja.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.codeninja.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ArtSpaceTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					ArtSpaceScreen()
				}
			}
		}
	}
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {
	Column(
		modifier = modifier
			.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		ArtworkDisplay()
		Spacer(modifier = modifier.size(16.dp))
		ArtworkTitle()
		Spacer(modifier = modifier.size(25.dp))
		ButtonControls()
	}
}

@Composable
fun ArtworkDisplay(modifier: Modifier = Modifier) {
	Image(
		painter = painterResource(R.drawable.deku),
		contentDescription = stringResource(id = R.string.deku),
		modifier = modifier.fillMaxWidth(),
		contentScale = ContentScale.FillWidth
	)
}

@Composable
fun ArtworkTitle() {
	Column (
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		// Artwork title
		Text(
			text = stringResource(id = R.string.deku),
			fontWeight = FontWeight.Bold,
			color = colorResource(id = R.color.blue_100),
			fontSize = 32.sp
		)
		
		// Artwork year
		Text(
			text = "— ${stringResource(id = R.string.deku_year)} —",
			fontSize = 16.sp,
			fontWeight = FontWeight.Medium,
			color = colorResource(id = R.color.gray_300)
		)
	}
}

@Composable
fun ButtonControls(
	modifier: Modifier = Modifier
) {
	Row(
		modifier = modifier.padding(horizontal = 8.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally)
	) {
		// Previous Button
		Button(
			onClick = { /*TODO*/ },
			colors = ButtonDefaults.buttonColors(
				backgroundColor = colorResource(id = R.color.gray_900)
			),
			elevation = ButtonDefaults.elevation(
				defaultElevation = 1.dp,
				pressedElevation = 0.dp,
				focusedElevation = 0.dp
			)
		) {
			Text(
				text = "Previous",
				fontSize = 16.sp,
				fontWeight = FontWeight.Medium,
				color = colorResource(id = R.color.blue_300)
			)
		}

		// Next Button
		Button(
			onClick = { /*TODO*/ },
			colors = ButtonDefaults.buttonColors(
				backgroundColor = colorResource(id = R.color.blue_300)
			),
			elevation = ButtonDefaults.elevation(
				defaultElevation = 1.dp,
				pressedElevation = 0.dp,
				focusedElevation = 0.dp
			)
		) {
			Text(
				text = "Next",
				fontSize = 16.sp,
				fontWeight = FontWeight.Medium,
				color = colorResource(id = R.color.gray_900)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ArtSpaceTheme {
		ArtSpaceScreen()
	}
}