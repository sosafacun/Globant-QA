package services;

import entities.BasicInfo;

public interface BasicInfoInterface {
    BasicInfo register();
    void fetchBasicInfo(BasicInfo info);
    BasicInfo update(BasicInfo oldInfo);
    void showPeople(BasicInfo info);
}
