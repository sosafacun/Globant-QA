
package POJOs;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"height",
"mass",
"hair_color",
"skin_color",
"eye_color",
"birth_year",
"gender",
"homeworld",
"films",
"species",
"vehicles",
"starships",
"created",
"edited",
"url"
})

public class People {

@JsonProperty("name")
private String name;
@JsonProperty("height")
private String height;
@JsonProperty("mass")
private String mass;
@JsonProperty("hair_color")
private String hairColor;
@JsonProperty("skin_color")
private String skinColor;
@JsonProperty("eye_color")
private String eyeColor;
@JsonProperty("birth_year")
private String birthYear;
@JsonProperty("gender")
private String gender;
@JsonProperty("homeworld")
private String homeworld;
@JsonProperty("films")
private List<String> films;
@JsonProperty("species")
private List<String> species;
@JsonProperty("vehicles")
private List<Object> vehicles;
@JsonProperty("starships")
private List<Object> starships;
@JsonProperty("created")
private String created;
@JsonProperty("edited")
private String edited;
@JsonProperty("url")
private String url;
@JsonIgnore
private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("height")
public String getHeight() {
return height;
}

@JsonProperty("height")
public void setHeight(String height) {
this.height = height;
}

@JsonProperty("mass")
public String getMass() {
return mass;
}

@JsonProperty("mass")
public void setMass(String mass) {
this.mass = mass;
}

@JsonProperty("hair_color")
public String getHairColor() {
return hairColor;
}

@JsonProperty("hair_color")
public void setHairColor(String hairColor) {
this.hairColor = hairColor;
}

@JsonProperty("skin_color")
public String getSkinColor() {
return skinColor;
}

@JsonProperty("skin_color")
public void setSkinColor(String skinColor) {
this.skinColor = skinColor;
}

@JsonProperty("eye_color")
public String getEyeColor() {
return eyeColor;
}

@JsonProperty("eye_color")
public void setEyeColor(String eyeColor) {
this.eyeColor = eyeColor;
}

@JsonProperty("birth_year")
public String getBirthYear() {
return birthYear;
}

@JsonProperty("birth_year")
public void setBirthYear(String birthYear) {
this.birthYear = birthYear;
}

@JsonProperty("gender")
public String getGender() {
return gender;
}

@JsonProperty("gender")
public void setGender(String gender) {
this.gender = gender;
}

@JsonProperty("homeworld")
public String getHomeworld() {
return homeworld;
}

@JsonProperty("homeworld")
public void setHomeworld(String homeworld) {
this.homeworld = homeworld;
}

@JsonProperty("films")
public List<String> getFilms() {
return films;
}

@JsonProperty("films")
public void setFilms(List<String> films) {
this.films = films;
}

@JsonProperty("species")
public List<String> getSpecies() {
return species;
}

@JsonProperty("species")
public void setSpecies(List<String> species) {
this.species = species;
}

@JsonProperty("vehicles")
public List<Object> getVehicles() {
return vehicles;
}

@JsonProperty("vehicles")
public void setVehicles(List<Object> vehicles) {
this.vehicles = vehicles;
}

@JsonProperty("starships")
public List<Object> getStarships() {
return starships;
}

@JsonProperty("starships")
public void setStarships(List<Object> starships) {
this.starships = starships;
}

@JsonProperty("created")
public String getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(String created) {
this.created = created;
}

@JsonProperty("edited")
public String getEdited() {
return edited;
}

@JsonProperty("edited")
public void setEdited(String edited) {
this.edited = edited;
}

@JsonProperty("url")
public String getUrl() {
return url;
}

@JsonProperty("url")
public void setUrl(String url) {
this.url = url;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

    @Override
    public String toString() {
        return "People{" + "name=" + name + ", height=" + height + ", mass=" + mass + ", hairColor=" + hairColor + ", skinColor=" + skinColor + ", eyeColor=" + eyeColor + ", birthYear=" + birthYear + ", gender=" + gender + ", homeworld=" + homeworld + ", films=" + films + ", species=" + species + ", vehicles=" + vehicles + ", starships=" + starships + ", created=" + created + ", edited=" + edited + ", url=" + url + ", additionalProperties=" + additionalProperties + '}';
    }



}
