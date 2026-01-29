package com.myname.game.events;


import com.badlogic.gdx.utils.Array;

public class ItemEventManager {

    private static Array<ItemListener> itemListeners = new Array<>();
    private static Array<InputListener> inputListeners = new Array<>();

    public static void newEvent(ItemEvent itemEvent)
    {
        for(ItemListener itemListener : itemListeners)
        {
            itemListener.answerEvent(itemEvent);
        }
    }

    public static void newInputEvent(InputEvent inputEvent)
    {
        for(InputListener inputListener : inputListeners)
        {
            inputListener.answerEventOnInput(inputEvent);
        }
    }

    public static void subscribe(ItemListener itemListener)
    {
        itemListeners.add(itemListener);
    }
    public static void subscribeInput(InputListener inputListener)
    {
        inputListeners.add(inputListener);
    }
}
