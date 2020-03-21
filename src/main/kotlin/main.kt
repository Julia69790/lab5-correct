
import data.lesson
import data.studentList
import react.dom.h1
import react.dom.li
import react.dom.ol
import react.dom.render
import kotlin.browser.document


fun main() {
    render(document.getElementById("root")!!) {
        val subject = "English"
        h1 {
            +"Students"
        }
        classPresent(studentList.toTypedArray(), lesson)
    }
}
