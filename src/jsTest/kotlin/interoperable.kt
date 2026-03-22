import kotlinx.browser.document
import kotlinx.html.js.div
import kotlinx.html.dom.append
import kotlinx.html.dom.dom
import kotlin.test.Test
import kotlin.test.assertEquals

class InteroperableImplTest {
    @Test fun testInteroperableDOM() {
        val wrapper = wrapper()

        wrapper.append.div {
            dom {
                document.createElement("svg")
            }
        }

        assertEquals(expected = "<div><svg></svg></div>", actual = wrapper.innerHTML)
    }

    private fun wrapper() = document.body!!.append.div {}
}