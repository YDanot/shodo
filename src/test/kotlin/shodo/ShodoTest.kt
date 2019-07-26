package shodo

import org.assertj.core.api.Assertions
import org.junit.Test
import shodo.glue.Glue

class ShodoTest {

    var glue: Glue = Glue()

    @Test
    fun konnichiwa() {
        given_syllabary_is_Hiragana()
        "Konnichiwa".should_be_shodoed_in("こんにちわ")
    }

    private fun given_syllabary_is_Hiragana() {
        glue.given_syllabary_is("ko->こ | chi->ち | ni->に | wa->わ | n->ん")
    }

    private fun String.should_be_shodoed_in(word: String) {
        Assertions.assertThat(Shodo(glue.syllabary).shodo(this)).isEqualTo(word)
    }

}
