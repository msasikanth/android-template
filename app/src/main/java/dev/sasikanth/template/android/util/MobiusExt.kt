package dev.sasikanth.template.android.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.spotify.mobius.android.LiveQueue

/**
 * Based on `LiveDataAdapter#observeAsState`
 *
 * Starts observing this [LiveQueue]. Every them there would be
 * new value emitted by [LiveQueue] the [onViewEffect] will
 * be called.
 *
 * The inner observer will be automatically cleared when
 * this composable disposes or the current [LifecycleOwner]
 * moves to the [Lifecycle.State.DESTROYED] state.
 */
@Composable
fun <T> LiveQueue<T>.Observer(onViewEffect: (T) -> Unit) {
  val lifecycleOwner = LocalLifecycleOwner.current

  DisposableEffect(lifecycleOwner) {
    setObserver(
        lifecycleOwner,
        { onViewEffect(it) },
        { pausedViewEffects -> pausedViewEffects.forEach(onViewEffect) }
    )

    onDispose { clearObserver() }
  }
}
