#!/bin/sh
# Script to build Calibre2opds on 'unix' like systems such as linux
# or mac including the building and running of the supplied tests.
#
# If you want to build without invoking the tests, then use the 
# makenotests.sh script instead

# The build system needs to know how to find the svnversion command

if [ ! -f $SVN_HOME/bin/svnversion ]
then
  # Try commonest default install location as a convenience
  SVN_HOME=/usr
  export SVN_HOME
  if [ ! -f $SVN_HOME/bin/svnversion ]
  then
  	echo 
  	echo  ERROR: Unable to locate the svnversion location
  	echo 
  	echo  Please set the SVN_HOME environment variable to the
  	echo  appropriate value either before running this script
  	echo  or by editing this script appropriately.
  	echo 
  fi
fi

mvn clean install dependency:copy-dependencies
