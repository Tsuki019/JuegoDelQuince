package com.rafa.juegodelquince

class Taken (){

    private var matriz = Array(4){IntArray(4)} //hor-ver
//    private val matrizImposible = arrayOf(intArrayOf(1,5,9,13), intArrayOf(2,6,10,14), intArrayOf(3,7,11,0), intArrayOf(4,8,12,15))
    private val matrizVertical = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12), intArrayOf(13,14,15,0))
    private val matrizPeriferico = arrayOf(intArrayOf(1,12,11,10), intArrayOf(2,13,0,9), intArrayOf(3,14,15,8), intArrayOf(4,5,6,7))
    private val matrizEspiral = arrayOf(intArrayOf(7,6,5,0), intArrayOf(8,1,4,15), intArrayOf(9,2,3,14), intArrayOf(10,11,12,13))
    private val matrizImposible = arrayOf(intArrayOf(15,11,7,3), intArrayOf(14,10,6,2), intArrayOf(13,9,5,1), intArrayOf(12,8,4,0))


    fun cambiarNumero(num: Int) : Boolean{

        var band1 = false
        var band = false
        var posX = 0
        var posY = 0
        var posX0 = 0
        var posY0 = 0

        for(i in 0 until 4){
            for(j in 0 until 4){
                if (matriz[j][i] == num){
                    posX = j
                    posY = i
                    band1 = true
                }
                if (matriz[j][i] == 0){
                    posX0 = j
                    posY0 = i
                    band1 = true
                }
            }
            if (band1 == true && band == true)
                break
        }

        if (posX == posX0){
            if ((posY - posY0) == -1 || (posY - posY0) == 1){
                matriz[posX0][posY0] = matriz[posX][posY]
                matriz[posX][posY] = 0
//                imprimirMatriz()
                return true
            }
        }else if (posY == posY0){
            if ((posX - posX0) == -1 || (posX - posX0) == 1){
                matriz[posX0][posY0] = matriz[posX][posY]
                matriz[posX][posY] = 0
//                imprimirMatriz()
                return true
            }
        }
        return false
    }

    fun verificarTablero() : Int{

        var band = true
        val cantidad = 4
        for(i in 0 until cantidad){
            for(j in 0 until cantidad){
                if (matriz[j][i] != matrizVertical[j][i]){
                    band = false
                    break
                }
            }
        }

        if (band){
            return 1
        }
        band = true
        for(i in 0 until cantidad){
            for(j in 0 until cantidad){
                println("${matriz[j][i]} != ${matrizPeriferico[j][i]}")
                if (matriz[j][i] != matrizPeriferico[j][i]){
                    band = false
                    break
                }
            }
        }

        if (band){
            return 2
        }
        band = true

        for(i in 0 until cantidad){
            for(j in 0 until cantidad){
                if (matriz[j][i] != matrizEspiral[j][i]){
                    band = false
                    break
                }
            }
        }

        if (band){
            return 3
        }
        band = true

        for(i in 0 until cantidad){
            for(j in 0 until cantidad){
                if (matriz[j][i] != matrizImposible[j][i]){
                    band = false
                    break
                }
            }
        }

        if (band){
            return 4
        }

        println("========ENVIA UN 0=========")
        return 0
    }

    fun llenarMatriz(){
        var contador = 1
        for(i in 0 until 4){
            for (j in 0 until 4) {
                if (contador != 16) {
                    matriz[j][i] = contador
                    contador++
                }else{
                    matriz[j][i] = 0
                }
            }
        }
        imprimirMatriz()
    }

    fun imprimirMatriz (){
        val cantidad = 4
        for(i in 0 until cantidad){
            for(j in 0 until cantidad){
                print("${matriz[j][i]}  ")
            }
            println()
        }

//        println("==========GANAR=========")
//        for(i in 0 until cantidad){
//            for(j in 0 until cantidad){
//                print("${matrizPeriferico[j][i]}  ")
//            }
//            println()
//        }
    }
}
