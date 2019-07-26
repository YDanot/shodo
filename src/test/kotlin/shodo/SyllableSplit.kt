package shodo

import org.assertj.core.api.Assertions
import org.junit.Test

class SyllableSplit {

    var existingSyllables = setOf<String>()

    @Test
    fun should_split_Kon_in_Ko_n() {
        given_existing_syllables_are("ko,n,ni,chi,wa")
        "kon".should_be_splitted_in_("ko,n")
    }

    @Test
    fun should_split_Konni_in_Ko_n_ni() {
        given_existing_syllables_are("ko,n,ni,chi,wa")
        "konni".should_be_splitted_in_("ko,n,ni")
    }

    @Test
    fun should_split_Konnichiwa_in_Ko_n_ni_chi_wa() {
        given_existing_syllables_are("ko,n,ni,chi,wa")
        "konnichiwa".should_be_splitted_in_("ko,n,ni,chi,wa")
    }

    private fun given_existing_syllables_are(s: String) {
        existingSyllables = s.split(",").toSet()
    }

    private fun String.should_be_splitted_in_(syllables: String) {
        Assertions.assertThat(Word(this).splitInSyllables(existingSyllables).reduce({ s1, s2 -> s1 + "," + s2 }))
            .isEqualTo(syllables)
    }

}



