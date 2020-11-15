import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */

/**
 * Problem is to merge overlapping intervals
 * Approach is to first sort all the intervals on the basis of startTime and if it is same then sort on endTime
 * After sorting is done then start iterating for every interval and check if any overlap is there if it is
 * then merge it other wise take the actual interval into consideration
 */
class Solution {
    
    class Interval {
        int start;
        int end;

        Interval(int a, int b) {
            start = a;
            end = b;
        }
    }
    
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return intervals;
        
        List<Interval> sortedIntervals = new ArrayList<>();
        List<Interval> mergedIntervals = new ArrayList<>();
        
        for(int[] eachInterval: intervals) {
            
            Interval interval = new Interval(eachInterval[0], eachInterval[1]);
            sortedIntervals.add(interval);
        
        }
        
        // Sorting on the basis of start Time if for both intervals startTime are not equal
        // If they are equal then sorting should be on the basis of endTime
        
        Collections.sort(sortedIntervals, (i1, i2) -> {
            
           if(i1.start != i2.start) {
               return i1.start > i2.start ? 1 : -1;
           } else {          
               if(i1.end == i2.end)
                   return 0;
               return i1.end > i2.end ? 1 : -1;
           }
            
        });
        
        Interval tempInterval = sortedIntervals.get(0);
        
        // This logic is to check whether intervals are overlapping or not
        // And if it is then take the maximum of endTime of intervals which are to be compared
        // And if not overlapping then we can safely take the interval having less startTime
            
        for(int i=1; i<sortedIntervals.size(); i++) {
            
            Interval eachInterval = sortedIntervals.get(i);
            
            if(tempInterval.end < eachInterval.start) {
            
                mergedIntervals.add(tempInterval);
                tempInterval = eachInterval;
            
            } else {
                
                Interval newInterval = new Interval(tempInterval.start, Math.max(tempInterval.end, eachInterval.end));
                tempInterval = newInterval;
                
            } 
            
        }
        
        mergedIntervals.add(tempInterval);
        
        // Prepare the result for the function in the format of int[][]
        
        int[][] result = new int[mergedIntervals.size()][2];
        
        for(int i=0; i<mergedIntervals.size(); i++) {
            
            result[i][0] = mergedIntervals.get(i).start;
            result[i][1] = mergedIntervals.get(i).end;
            
        }
        
        return result;
    }
}