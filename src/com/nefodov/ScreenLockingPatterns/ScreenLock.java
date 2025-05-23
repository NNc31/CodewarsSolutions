package com.nefodov.ScreenLockingPatterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ScreenLock {

    Set<Character> aDirect = new HashSet<>();
    Map<Character, Character> aOverUsed = new HashMap<>();
    Set<Character> bDirect = new HashSet<>();
    Map<Character, Character> bOverUsed = new HashMap<>();
    Set<Character> cDirect = new HashSet<>();
    Map<Character, Character> cOverUsed = new HashMap<>();
    Set<Character> dDirect = new HashSet<>();
    Map<Character, Character> dOverUsed = new HashMap<>();
    Set<Character> eDirect = new HashSet<>();
    Map<Character, Character> eOverUsed = new HashMap<>();
    Set<Character> fDirect = new HashSet<>();
    Map<Character, Character> fOverUsed = new HashMap<>();
    Set<Character> gDirect = new HashSet<>();
    Map<Character, Character> gOverUsed = new HashMap<>();
    Set<Character> hDirect = new HashSet<>();
    Map<Character, Character> hOverUsed = new HashMap<>();
    Set<Character> iDirect = new HashSet<>();
    Map<Character, Character> iOverUsed = new HashMap<>();

    Map<Character, Set<Character>> directMap = new HashMap<>();
    Map<Character, Map<Character, Character>> overUsedMap = new HashMap<>();
    Set<Character> usedChars = new HashSet<>();

    public int calculateCombinations(char startPosition, int patternLength) {

        if (patternLength < 1 || patternLength > 9) {
            return 0;
        }

        aDirect.add('B');
        aDirect.add('D');
        aDirect.add('E');
        aDirect.add('F');
        aDirect.add('H');
        aOverUsed.put('B', 'C');
        aOverUsed.put('D', 'G');
        aOverUsed.put('E', 'I');

        bDirect.add('A');
        bDirect.add('C');
        bDirect.add('D');
        bDirect.add('E');
        bDirect.add('F');
        bDirect.add('G');
        bDirect.add('I');
        bOverUsed.put('E', 'H');

        cDirect.add('B');
        cDirect.add('D');
        cDirect.add('E');
        cDirect.add('F');
        cDirect.add('H');
        cOverUsed.put('B', 'A');
        cOverUsed.put('E', 'G');
        cOverUsed.put('F', 'I');

        dDirect.add('A');
        dDirect.add('B');
        dDirect.add('C');
        dDirect.add('E');
        dDirect.add('G');
        dDirect.add('H');
        dDirect.add('I');
        dOverUsed.put('E', 'F');

        eDirect.add('A');
        eDirect.add('B');
        eDirect.add('C');
        eDirect.add('D');
        eDirect.add('F');
        eDirect.add('G');
        eDirect.add('H');
        eDirect.add('I');

        fDirect.add('A');
        fDirect.add('B');
        fDirect.add('C');
        fDirect.add('E');
        fDirect.add('G');
        fDirect.add('H');
        fDirect.add('I');
        fOverUsed.put('E', 'D');

        gDirect.add('B');
        gDirect.add('D');
        gDirect.add('E');
        gDirect.add('F');
        gDirect.add('H');
        gOverUsed.put('D', 'A');
        gOverUsed.put('E', 'C');
        gOverUsed.put('H', 'I');

        hDirect.add('A');
        hDirect.add('C');
        hDirect.add('D');
        hDirect.add('E');
        hDirect.add('F');
        hDirect.add('G');
        hDirect.add('I');
        hOverUsed.put('E', 'B');

        iDirect.add('B');
        iDirect.add('D');
        iDirect.add('E');
        iDirect.add('F');
        iDirect.add('H');
        iOverUsed.put('E', 'A');
        iOverUsed.put('F', 'C');
        iOverUsed.put('H', 'G');

        directMap.put('A', aDirect);
        overUsedMap.put('A', aOverUsed);
        directMap.put('B', bDirect);
        overUsedMap.put('B', bOverUsed);
        directMap.put('C', cDirect);
        overUsedMap.put('C', cOverUsed);
        directMap.put('D', dDirect);
        overUsedMap.put('D', dOverUsed);
        directMap.put('E', eDirect);
        overUsedMap.put('E', eOverUsed);
        directMap.put('F', fDirect);
        overUsedMap.put('F', fOverUsed);
        directMap.put('G', gDirect);
        overUsedMap.put('G', gOverUsed);
        directMap.put('H', hDirect);
        overUsedMap.put('H', hOverUsed);
        directMap.put('I', iDirect);
        overUsedMap.put('I', iOverUsed);
        usedChars.clear();
        usedChars.add(startPosition);
        return findRoute(startPosition, patternLength);
    }

    private int findRoute(char startPosition, int patternLength) {
        if (patternLength == 1) {
            return 1;
        }
        int totalRoutes = 0;

        Set<Character> currDirect = directMap.get(startPosition);
        Map<Character, Character> currOverUsed = overUsedMap.get(startPosition);

        for (Character c : currDirect) {
            if (!usedChars.contains(c)) {
                usedChars.add(c);
                totalRoutes += findRoute(c, patternLength - 1);
                usedChars.remove(c);
            }
        }

        for (Character key : currOverUsed.keySet()) {
            if (usedChars.contains(key)) {
                Character value = currOverUsed.get(key);
                if (!usedChars.contains(value)) {
                    usedChars.add(value);
                    totalRoutes += findRoute(value, patternLength - 1);
                    usedChars.remove(value);
                }
            }
        }

        return totalRoutes;
    }
}