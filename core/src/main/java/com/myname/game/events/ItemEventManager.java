package com.myname.game.events;


import com.badlogic.gdx.utils.Array;

public class ItemEventManager {

    private static Array<ItemListener> itemListeners = new Array<>();

    public static void newEvent(ItemEvent itemEvent)
    {
        for(ItemListener itemListener : itemListeners)
        {
            itemListener.answerEvent(itemEvent);
        }
    }

    public static void subscribe(ItemListener itemListener)
    {
        itemListeners.add(itemListener);
    }
}
