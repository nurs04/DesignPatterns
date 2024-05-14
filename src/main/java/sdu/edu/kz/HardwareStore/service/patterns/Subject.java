package sdu.edu.kz.HardwareStore.service.patterns;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
