package ua.antibyte.designviewpagertransitions

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.inputmethod.BaseInputConnection
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object {
        const val TRANSFORMATION_INDEX_KEY = "TRANSFORMATION_INDEX_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemProgressBar()
        setContentView(R.layout.activity_main)
        initViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        transformations.forEachIndexed { index, _ ->
            menu.add(0, index, 0, createTitle(index))
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        saveIndexAndRestartActivity(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun hideSystemProgressBar() {
        hideSystemUI();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
        }
    }

    private fun createTitle(index: Int) = "$index ${transformations[index]::class.java.simpleName}"

    private fun initViewPager() {
        view_pager.adapter = createViewPagerAdapter()
        view_pager.setPageTransformer(transformations[getCurrentIndex()])
    }

    private fun getCurrentIndex() = intent.getIntExtra(TRANSFORMATION_INDEX_KEY, 9)

    private fun saveIndexAndRestartActivity(index: Int) {
        finish()
        intent.putExtra(TRANSFORMATION_INDEX_KEY, index)
        startActivity(intent)
    }

    private fun hideSystemUI() {
        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    private fun createViewPagerAdapter() =
        ViewPagerAdapter(object : ViewPagerAdapter.ClickListener {
            override fun onClick() {
                val mInputConnection = BaseInputConnection(findViewById(R.id.main_content), true)
                val kd = KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_MENU)
                val ku = KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_MENU)
                mInputConnection.sendKeyEvent(kd)
                mInputConnection.sendKeyEvent(ku)
            }

        }).apply {
            setData(data)
        }
}