package core;

import java.util.Map;

public class UsersManagement
{
    public Map<String, String> register;
    public Map<String, String> followers;

    public UsersManagement(Map<String, String> register, Map<String, String> followers)
    {
        this.register = register;
        this.followers = followers;
    }

    public void addFollower(String user, String follower)
    {
        String cf = followers.get(user);

        StringBuffer currentFollower = new StringBuffer();

        if (userHasNoFollower(cf))
        {
            currentFollower.append(follower);
        }
        else if (!currentFollower.equals(""))
        {
            currentFollower.append(cf).append(",").append(follower);
        }

        followers.put(user, currentFollower.toString());

    }

    public boolean userHasNoFollower(String cf)
    {
        return cf == null;
    }
}
