package com.example.kakaopractice.util

import com.example.kakaopractice.network.response.KakaoBookItem

interface BookMarkInsertClick {
        fun onInsertClick(item: KakaoBookItem)


}



interface BookMarkDeleteClick {

        fun onDeleteClick(item: KakaoBookItem)

}