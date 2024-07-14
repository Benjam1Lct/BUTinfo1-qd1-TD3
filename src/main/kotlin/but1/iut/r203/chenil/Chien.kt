package but1.iut.r203.chenil

import java.time.LocalDate
import java.time.Period

class Chien (nomParam : String, raceParam : String){
    val nom = nomParam
    val race = raceParam
    private var dateNaissance : LocalDate? = null
        set(value) {
            field = value
        }

    /**
     * Affecte une date de naissance au chien
     * @param anneeNaissance: Int
     * @param moisNaissance: Int
     * @param jourNaissance: Int
     * @throws DateTimeException : quand les paramètres sont incorrects
     */
    fun setDateNaissance(anneeNaissance: Int, moisNaissance: Int, jourNaissance: Int) {
        dateNaissance = LocalDate.of(anneeNaissance, moisNaissance, jourNaissance)
    }

    /**
     * Calcule l'age en mois du chien
     * @return age : Long
     */
    fun ageMois(): Long {
        var dateJour : LocalDate
        dateJour = LocalDate.now()
        println("Date du jour : " + dateJour)
        var ecart = Period.between(dateNaissance, dateJour)
        return ecart.years * 12L + ecart.months
    }

    /**
     * Calcule l'age en mois du chien par rapport à une date choisie en console
     * @return age : Long
     */
    fun ageMoisDateConsole(): Long {
        var dateChoisie : LocalDate
        print("Année ? ")
        var anneeConsole = Integer.valueOf(readLine())
        print("Mois ? ")
        var moisConsole = Integer.valueOf(readLine())
        print("Jour ? ")
        var jourConsole = Integer.valueOf(readLine())

        dateChoisie = LocalDate.of(anneeConsole, moisConsole, jourConsole)

        var ecart = Period.between(dateNaissance, dateChoisie)
        return ecart.years * 12L + ecart.months
    }

    override fun toString(): String {
        return "Chien(nom='$nom', race='$race', dateNaissance=$dateNaissance)"
    }
}