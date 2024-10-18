package com.mobdeve.s20.andres.wray.amplify

class Generator {
    companion object {
        fun loadData(): ArrayList<Music> {
            val sabrina = Artist("Sabrina", 142552, 10,  R.drawable.sabrina, "@sabriger")
            val niki = Artist("Niki", 4242552, 10,  R.drawable.niki, "@nikkier")
            val phoebe = Artist("Phoebe Bridges", 145252, 10, R.drawable.phoebe, "@phoebix")
            val clairo = Artist("Clairo", 8413553, 2, R.drawable.clairo, "@clairerthanever")
            val blink = Artist("Blink 182", 853178, 1, R.drawable.blink, "@blinkandimgone")
            val data = ArrayList<Music>()

            data.add(Music(sabrina, R.raw.sabrina_good_graces, 2032, "Good Graces"))
            data.add(Music(sabrina, R.raw.sabrina_bed_chem, 20123, "Bed Chem"))
            data.add(Music(niki, R.raw.niki_focus,  12455, "Focus"))
            data.add(Music(phoebe, R.raw.phoebe_motion_sickness,  5436, "Motion Sickness"))
            data.add(Music(phoebe, R.raw.phoebe_scott_street,  5325, "Scott Street"))
            data.add(Music(clairo, R.raw.clairo_juna, 151366, "Juna"))
            data.add(Music(clairo, R.raw.clairo_nomad, 251561, "Nomad"))
            data.add(Music(clairo, R.raw.clairo_sofia,  1251346, "Sofia"))
            data.add(Music(blink, R.raw.blink_182_i_miss_you,  5136246, "I Miss You"))
            data.add(Music(blink, R.raw.blink_182_whats_my_age_again, 15362346, "What's My Age Again"))
            return data
        }
    }
}