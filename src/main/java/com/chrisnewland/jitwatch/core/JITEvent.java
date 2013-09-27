/*
 * Copyright (c) 2013 Chris Newland. All rights reserved.
 * Licensed under https://github.com/chriswhocodes/jitwatch/blob/master/LICENSE-BSD
 * http://www.chrisnewland.com/jitwatch
 */
package com.chrisnewland.jitwatch.core;

import com.chrisnewland.jitwatch.util.StringUtil;

public class JITEvent
{
    private long stamp;
    private boolean isCompile;
    private String methodSignature;
    private String stampString;

    public JITEvent(long stamp, boolean isCompile, String methodSignature)
    {
        this.stamp = stamp;
        this.isCompile = isCompile;
        this.methodSignature = methodSignature;

        this.stampString = StringUtil.formatTimestamp(stamp, true);
    }

    public long getStamp()
    {
        return stamp;
    }

    public boolean isCompile()
    {
        return isCompile;
    }

    public String getMethodSignature()
    {
        return methodSignature;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(stampString);

        if (isCompile)
        {
            sb.append("  Compiled: ");
        }
        else
        {
            sb.append("    Queued: ");
        }

        sb.append(methodSignature);

        return sb.toString();
    }
}
