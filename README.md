# lab5-correct
Исправления:<br>
1. Создан класс данных Lesson, инициализирован один урок:<br>
data class Lesson (
    val name:String
)
val lesson = Lesson("lesson 1")<br>
2. В свойтсва RClassPresent добавлен lesson:

interface RClassPresentProps : RProps {<br>
    var students: Array\<Student><br>
    var lesson:Lesson<br>
}<br>
interface RClassPresentState: RState{<br>
    var present: Array\<Boolean><br>
}<br>

class RClassPresent: RComponent<RClassPresentProps, RClassPresentState>() {

    override fun componentWillMount() {
        state.apply {
            present = Array(props.students.size) { false }
        }
    }

    fun onClick(index:Int): (Event) -> Unit = {
        setState {
            state.present[index] = !state.present[index]
        }
    }

    override fun RBuilder.render() {
        val click = props.students.mapIndexed { index, student -> onClick(index) }
          h2{ + props.lesson.name}
            studentList(props.students, state.present, click)
    }
}

     fun RBuilder.classPresent(students: Array<Student>,lesson:Lesson ) =
        child(RClassPresent::class) {
            attrs.students = students
            attrs.lesson = lesson
        }
3. В main:
classPresent(studentList.toTypedArray(), lesson)
