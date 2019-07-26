package shodo

import org.assertj.core.api.Assertions
import org.junit.Test
import shodo.glue.Glue

class KanaScripting {

    var glue: Glue = Glue()

    @Test
    fun should_find_kana_in_syllabary() {
        given_syllabary_is("Ko->こ | ni->に | K->★")

        "Ko".toKana().should_be('こ')
        "ni".toKana().should_be('に')
        "K".toKana().should_be('★')
    }

    private fun given_syllabary_is(s: String) {
        glue.given_syllabary_is(s)
    }

    private fun String.toKana(): Char {
        return glue.toKana(this)
    }

    private fun Char.should_be(c: Char) {
        Assertions.assertThat(this).isEqualTo(c)
    }
}

