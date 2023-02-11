package com.splabs.lib;

public class IterativeHealth {
    /*
    For a list of entries containing 3 data
    - id
    - start time
    - end time
    : return the number of entries for each id in the data
    :: assume:
    - all entries are properly formatted
    - start and end are always in right order
    - all entries have always 3 values

    input:
    {{1,8,9},{1,4,7},{1,2,5},{1,6,8},{1,5,7},{2,4,9}}
    Expected output
    {1,5},{2,1}
     */
    public void countVideos(int[][] input) {

    }

    /*
    Same dataset as above
    Combine all the clips for the same id, into a single one
    and return the required start and end to include all the clips in one

    input:
    {{1,8,9},{1,4,7},{1,2,5},{1,6,8},{1,5,7},{2,4,9}}
    Expected output
    {1,2,9},{2,4,9}

     */
    public void mergeClips(int[][] input) {

    }
}
