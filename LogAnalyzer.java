/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author Salvatore Anzalone
 * @version 10.13.2022
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;
    //The amount of times the log was accessed in a day.
    private int day;
    //The amount of times the log was accessed in a month.
    private int month;
    //The number of times the log file is accessed.
    private int total;
    //The average amount of times the log file was accessed.
    private int average;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader("demo.log");
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Give the amount of times the log file was accessed.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    
        return total;
    }

    /**
     * Gives the busiest hour in the log file.
     */
    public void busiestHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour >= 6)
            {
                System.out.println("This was the busiest hour: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the busiest day in the log file.
     */
    public void busiestDay()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour >= 6)
            {
                System.out.println("This was the busiest day: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the busiest month in the log file.
     */
    public void busiestMonth()
    {
        day++;
        
        if(day > 31)
        {
            day = month;
        }
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour >= 6)
            {
                System.out.println("This was the busiest month: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the quietest hour in the log file.
     */
    public void quietestHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour < 4)
            {
                System.out.println("This was the quietest hour: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the quietest day in the log file.
     */
    public void quietestDay()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour >= 6)
            {
                System.out.println("This was the quietest day: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the quietest month in the log file.
     */
    public void quietestMonth()
    {
        day++;
        
        if(day > 31)
        {
            day = month;
        }
        
        
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour >= 6)
            {
                System.out.println("This was the quietest month: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Gives the busiest hour in the log file from start to finish.
     */
    public void busiestTwoHour()
    {
        for(int hour = 0; hour < hourCounts.length; hour++)
        {
            if(hour <= 23)
            {
                System.out.println("This was the busiest hour: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
            
            else
            {
                System.out.println("This wasn't the busiest hour.");
                System.out.println("This hour will be exempt.");
            }
            
            if(hour >= 6)
            {
                System.out.println("This was the busiest hour: ");
                System.out.println(hour + ": " + hourCounts[hour]);
            }
        }
    }
    
    /**
     * Returns the total amount of times the log file was accessed.
     */
    public int totalAccessesPerMonth()
    {
        return total;
    }
    
    /**
     * Give the average amount of times the log file was accessed.
     */
    public int averageAccessesPerMonth()
    {
        average = total / 31;
        
        if(average != total / 31)
        {
            average = total / 30;
        }
        
        else
        {
            average = total / 28;
        }
        
        return average;
    }
    
    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
}