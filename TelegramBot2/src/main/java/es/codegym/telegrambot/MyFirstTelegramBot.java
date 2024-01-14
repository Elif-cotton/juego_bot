package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static final String NAME = "CodeCottonBot_bot";
    public static final String TOKEN = "6957737514:AAHn6HC-lzRaeVveLhEjcOg8TJeiTRvMnkw";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        if (getMessageText().equals("/start")) {
            setUserGlory(0);            //método suma puntos juego

            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT,
                    Map.of("Hackear la nevera", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) { //identifica el botón que se hizo clic
            setUserGlory(20);

            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("¡Tomar una salchicha! +20 de fama","step_2_btn",
                            "¡Tomar un pescado! +20 de fama","step_2_btn",
                            "¡Tirar una lata de pepinillos! +20 de fama","step_2_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_2_btn")) { //identifica el botón que se hizo clic
            setUserGlory(20);

            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspirador","step_3_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) { //identifica el botón que se hizo clic
            addUserGlory(30);

            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("¡jugar a las escondidas con la robot aspiradora! +30 de fama","step_4_btn",
                            "¡Dar un paseo en el robot aspirador! +30 de fama","step_4_btn",
                            "¡Huir del robot aspirador! +30 de fama","step_4_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_4_btn")) { //identifica el botón que se hizo clic
            addUserGlory(30);

            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("¡Ponte la GoPro y enciéndela! +30 de fama","step_5_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_5_btn")) { //identifica el botón que se hizo clic
            addUserGlory(40); //140

            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("¡Grabar a los pájaros desde la ventana! +40 de fama","step_6_btn",
                            "¡Grabar al perro comiendo! +40 de fama","step_6_btn",
                            "¡Grabar otros gatos jugando en la calle! +40 de fama","step_6_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_6_btn")) { //identifica el botón que se hizo clic
            addUserGlory(40);

            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("¡Hackea la contrseña de la computadora! +40 de fama","step_7_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) { //identifica el botón que se hizo clic
            addUserGlory(50);//230

            sendPhotoMessageAsync("step_8_PIC");
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Puedes editar el video","step_8_btn",
                            "Puedes poner música a tú video","step_8_btn",
                            "Puedes salir al patio a jugar","step_8_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_8_btn")) { //identifica el botón que se hizo clic

            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT,
                    Map.of("Final del juego, haz ganado","step_9_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_9_btn")) { //identifica el botón que se hizo clic

            sendPhotoMessageAsync("final");
        }

    }
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}