package io.mendirl.adventofcode20

class Day4 : Day {
    override fun step1(inputs: List<String>): Int {
        return calcul(
            inputs,
            listOf {
                listOf("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:").all { it2 -> it.contains(it2) }
            })
    }

    override fun step2(inputs: List<String>): Int {
        return calcul(
            inputs,
            listOf({ passport -> passport.fieldAsInt("byr:") in (1920..2002) },
                { passport -> passport.fieldAsInt("iyr:") in (2010..2020) },
                { passport -> passport.fieldAsInt("eyr:") in (2020..2030) },
                { passport ->
                    when {
                        passport.field("hgt:").contains("cm") -> passport.fieldAsInt("hgt:", "cm") in (150..193)
                        passport.field("hgt:").contains("in") -> passport.fieldAsInt("hgt:", "in") in (59..76)
                        else -> false
                    }
                },
                { passport -> passport.field("hcl:").matches(Regex("#[a-f0-9]{6}")) },
                { passport -> passport.field("ecl:") in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
                { passport -> passport.field("pid:").matches(Regex("\\d{9}")) }
            )
        )
    }

    private fun calcul(inputs: List<String>, rules: List<((passport: String) -> Boolean)>): Int {
        val passports = inputs.reduce { x, y -> "$x $y" }.split("  ")

        return passports.filter { passport -> rules.all { rule -> rule(passport) } }.count()
    }
}

private fun String.fieldAsInt(field: String, toRemove: String): Int {
    return this.field(field).replace(toRemove, "").toInt()
}

private fun String.fieldAsInt(field: String): Int {
    return this.field(field).toInt()
}

private fun String.field(field: String): String {
    return this.split(" ")
        .filter { it.contains(field) }
        .fold("") { a, b -> a + b }
        .ifEmpty { "0:0" }
        .split(":")[1]
}


