package api;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Abstract class for Weather
 */
public abstract class AbstractWeather implements Weather {
    private final CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();

    /**
     * Notify listeners that the weather list was modified
     */
    void notifyModifiedWeatherListeners() {
        for (Listener listener : listeners) {
            listener.modifiedWeatherList();
        }
    }

    /**
     * Notify listeners that the weather list encountered as error
     */
    void notifyErrorWeatherListeners() {
        for (Listener listener : listeners) {
            listener.errorWeatherList();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addListener(Listener listener) {
        synchronized (listeners) {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeListener(Listener listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }
}
