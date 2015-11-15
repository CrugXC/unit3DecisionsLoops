import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @gcschmit
 * @version 18 July 2014
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;
    
    // the game board will have 15 rows and 40 columns
    private final int ROWS = 40;
    private final int COLS = 40;
    
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame();
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    public GameOfLife(int check)
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);
        
        // create a world based on the grid
        world = new ActorWorld(grid);
        
        // populate the game
        populateGame(1);
        
        // display the newly constructed and populated world
        world.show();
        
    }
    
    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // constants for the location of the three cells initially alive
        final int X1 = 1, Y1 = 2;
        final int X2 = 2, Y2 = 1;
        final int X3 = 2, Y3 = 3;
        final int X4 = 3, Y4 = 2;
        final int X5 = 4, Y5 = 1;

        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();
        
        // create and add rocks (a type of Actor) to the three intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        grid.put(loc1, rock1);
        
        Rock rock2 = new Rock();
        Location loc2 = new Location(Y2, X2);
        grid.put(loc2, rock2);
        
        Rock rock3 = new Rock();
        Location loc3 = new Location(Y3, X3);
        grid.put(loc3, rock3);
        
        Rock rock4 = new Rock();
        Location loc4 = new Location(Y4, X4);
        grid.put(loc4, rock4);
        
        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5, X5);
        grid.put(loc5, rock5);
    }
    
    private void populateGame(int select)
    {
        int[] rowList = {6, 6, 7, 7, 4, 4, 5, 5, 6, 6, 7, 7, 7, 7, 8, 8, 9, 9, 10, 10, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 4, 4, 5, 5};
        int[] colList = {3, 4, 3, 4, 15, 16, 14, 18, 19, 13, 13, 17, 19, 20, 19, 13, 14, 18, 15, 16, 27, 25, 27, 23, 24, 23, 24, 23, 24, 25, 27, 27, 37, 38, 37, 38};
        
        Grid<Actor> grid = world.getGrid();
        
        for (int index = 0;
             index < rowList.length;
             index++)
        {
            grid.put(new Location(rowList[index], colList[index]), new Rock());
        }
    }
    
    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */
        
        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        
        // insert magic here...
        ArrayList <Boolean> willDie = new ArrayList<Boolean>();
        ArrayList <Location> locList = grid.getOccupiedLocations();
        
        for (Location currLoc: locList)
        {
            if(grid.getOccupiedAdjacentLocations(currLoc).size() > 3 || grid.getOccupiedAdjacentLocations(currLoc).size() < 2)
            {
                willDie.add(true);
            }
            
            else
            {
                willDie.add(false);
            }
        }
        
        ArrayList <Location> emptyLocList = new ArrayList <Location>();
        ArrayList <Location> spawnHere = new ArrayList<Location>();
        
        for (Location currLoc: locList)
        {
            emptyLocList = grid.getEmptyAdjacentLocations(currLoc);
            
            for(Location emptyCurrLoc: emptyLocList)
            {
                if (grid.getOccupiedAdjacentLocations(emptyCurrLoc).size() == 3)
                {
                    spawnHere.add(emptyCurrLoc);
                }
            }
        }
        
        for (Location spawn: spawnHere)
        {
            grid.put(spawn, new Rock());
        }
        
        spawnHere.clear();
        
        for (int index = 0;
             index < locList.size();
             index ++)
        {
            System.out.println(locList.get(index) + "\t" + willDie.get(index));
            if (willDie.get(index) == true)
            {
                grid.remove(locList.get(index));
            }
        }
        
    }
    
    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }
    
    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }
    
    
    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
        throws InterruptedException
    {
        GameOfLife game = new GameOfLife(1);
        
        Scanner s1 = new Scanner(System.in);
        
        System.out.print("Generations: ");
        int genTimes = 0;
        
        while (s1.hasNextInt())
        {
            genTimes = s1.nextInt();
            for (int i = 0;
                 i < genTimes;
                 i++)
            {
                game.createNextGeneration();
                Thread.sleep(500);
            }
            
            System.out.print("Generations: ");
        }
    }

}
