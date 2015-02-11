package core;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import core.UsersManagement;

public class UserManagementTest
{
    private final UsersManagement userManager = new UsersManagement(new HashMap<String, String>(),
            new HashMap<String, String>());

    @Before
    public void setUp()
    {
        userManager.register.put("@pasku1", "pepe");
    }

    @Test
    public void registerUser()
    {

        Assert.assertNotNull(userManager.register.get("@pasku1"));
    }

    @Test
    public void canNotRegisterAnRegistedUser()
    {

        String existingUser = userManager.register.put("@pasku1", "gerardito");

        Assert.assertNotNull("user should be allready register", existingUser);
    }

    @Test
    public void followUser()
    {
        userManager.register.put("@manolito", "manue");
        userManager.followers.put("@pasku1", "@manolito");

        String currentFollower = userManager.followers.get("@pasku1");

        Assert.assertEquals("Pasku1 should follow @manolito", "@manolito", currentFollower);
    }

    @Test
    public void listFollowers()
    {
        userManager.register.put("@manolito", "manue");
        userManager.register.put("@jorgito", "jorge");
        userManager.addFollower("@pasku1", "@manolito");

        String followersList = userManager.followers.get("@pasku1");

        Assert.assertTrue("Follower list should contains manolito",
                          followersList.equalsIgnoreCase("@manolito"));

        userManager.addFollower("@pasku1", "@jorgito");
        followersList = userManager.followers.get("@pasku1");
        System.out.print(followersList);
        Assert.assertTrue("Follower list should contains manolito and jorgito",
                          followersList.equalsIgnoreCase("@manolito,@jorgito"));

    }

}
