package com.github.jhamin0511.mystudy.ui.notification.style

import android.content.Context
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import androidx.core.app.Person
import androidx.core.graphics.drawable.IconCompat
import com.github.jhamin0511.mystudy.R

enum class Style {
    BIG_PICTURE {
        override fun getStyle(context: Context): NotificationCompat.Style {
            val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.img_receipt)

            return NotificationCompat.BigPictureStyle().bigPicture(bitmap)
        }
    },
    BIG_TEXT {
        override fun getStyle(context: Context): NotificationCompat.Style {
            val text = context.getText(R.string.channel_style_description)
            val longString = "$text + $text + $text + $text + $text + $text"

            return NotificationCompat.BigTextStyle().bigText(longString)
        }
    },
    MESSAGING {
        override fun getStyle(context: Context): NotificationCompat.Style {
            val iconCompat = IconCompat.createWithResource(context, R.drawable.ic_comment)
            val person = Person.Builder().apply {
                setName("Style Person")
                setIcon(iconCompat)
                setUri("https://github.com/jhamin0511/MyStudy")
                setKey("Style")
            }.build()
            val time = System.currentTimeMillis()
            val sender1 = Person.Builder().apply {
                setName("Sender #1")
            }.build()
            val sender2 = Person.Builder().apply {
                setName("Sender #2")
            }.build()
            val style = NotificationCompat.MessagingStyle(person)
            style.addMessage("안녕하세요.", time, sender1)

            return style.addMessage("안녕희 가세요,.", time, sender2)
        }
    },
    INBOX {
        override fun getStyle(context: Context): NotificationCompat.Style {
            return NotificationCompat.InboxStyle()
                .addLine("ADD LINE 1")
                .addLine("ADD LINE 2")
                .setSummaryText("+3 more")
        }
    };

    abstract fun getStyle(context: Context): NotificationCompat.Style
}
