//package models;
//
//import java.math.BigInteger;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//
//import org.ethereum.crypto.ECKey;
//import org.web3j.crypto.Credentials;
//
///**
// * User
// */
//public class User {
//
//    private String name;
//    private String email;
//    private String userID;
//    private ECKey keys;
//    private Map<String, String> keysPlainText;
//    private PersonalKeysJSON ABEKeys;
//    private List<Recording> recordings;
//    private String address;
//    private Credentials credentials;
//
//    public User(String name, String userID, String email, Map<String, String> ECKeys) {
//        setName(name);
//        setUserID(userID);
//        setEmail(email);
//        setECKeysFromString(ECKeys);
//        BigInteger privateKey = new BigInteger(ECKeys.get("private"), 16);
//        setECKeys(ECKey.fromPrivate(privateKey));
//        credentials = Credentials.create(ECKeys.get("private"));
//        setAddress(credentials.getAddress());
//        recordings = new ArrayList<Recording>();
//        ABEKeys = new PersonalKeysJSON(userID);
//    }
//
//    public User(String name, String email/*, ECKey ecKey*/) {
//        this.setName(name);
//        this.setEmail(email);
//        this.setECKeys(ecKey);
//
//        recordings = new ArrayList<Recording>();
//
//        String[] ecKeyStr = ecKey.toStringWithPrivate().split("pub:| priv:");
//        keysPlainText = new HashMap<String, String>();
//        keysPlainText.put("public", ecKeyStr[1]);
//        keysPlainText.put("private", ecKeyStr[2]);
//        credentials = Credentials.create(ecKeyStr[2]);
//        setAddress(credentials.getAddress());
//        String userID = String.format("%s-%s", name, this.address);
//        this.setUserID(userID);
//        this.ABEKeys = new PersonalKeysJSON(userID);
//    }
//
//    /**
//     * Getters and Setters that are written as json properties
//     */
//    public String getID() {
//        return userID;
//    }
//
//    public void setUserID(String userID) {
//        this.userID = userID;
//    }
//
//    public Map<String, String> getECKeysAsString() {
//        return keysPlainText;
//    }
//
//    public void setECKeysFromString(Map<String, String> keys) {
//        this.keysPlainText = keys;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public PersonalKeysJSON getABEKeys() {
//        return ABEKeys;
//    }
//
//    public void setABEKeys(PersonalKeysJSON ABEKeys) {
//        this.ABEKeys = ABEKeys;
//    }
//
//    /**
//     * Getters methods excluded from serialization
//     */
//
//    public List<Recording> getRecordings() {
//        return recordings;
//    }
//
//    public void setRecordings(List<Recording> recordings) {
//        this.recordings = recordings;
//    }
//
//
//    public ECKey getECKeys() {
//        return keys;
//    }
//
//    public void setECKeys(ECKey pairKeys) {
//        this.keys = pairKeys;
//    }
//
//    public String getPublicECKey() {
//        return this.keysPlainText.get("public");
//    }
//
//    public String getPrivateECKey() {
//        return keysPlainText.get("private");
//    }
//
//    @Override
//    public String toString() {
//        String format = "{\n" +
//                "\tname: %s, \n"+
//                "\temail: %s, \n"+
//                "\tprivate ECKey: %s, \n"+
//                "\tpublic ECKey: %s\n" +
//                "}";
//        return String.format(format,name, email, keysPlainText.get("private"),
//                keysPlainText.get("public"));
//    }
//
//    public void addRecording(Recording r) {
//        this.recordings.add(r);
//    }
//
//    public void addAllRecordings(List<Recording> r) {
//        this.recordings.addAll(r);
//    }
//
//    public Recording getRecordingByFile(String file) {
//        for (Recording r : recordings) {
//            if(r.getFileName().equals(file)) {
//                return r;
//            }
//        }
//        return null;
//    }
//
//    public void removeRecordByFileName(String fileName) {
//        for (int i = 0; i < recordings.size(); i++) {
//            if (recordings.get(i).getFileName().equals(fileName)) {
//                recordings.remove(i);
//                break;
//            }
//        }
//    }
//
//    public Credentials getCredentials() {
//        return credentials;
//    }
//}
