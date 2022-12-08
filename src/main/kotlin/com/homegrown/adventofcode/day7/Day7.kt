package com.homegrown.adventofcode.day7

class Day7 constructor(val commandsToProcess: Iterator<String>) {

    fun solve1(): Long {

        commandsToProcess.next()
        val root = Directory("/", ArrayList(), ArrayList(), null);
        buildDirTree(commandsToProcess.next(), root)

        return root.getDirsUnder(100000).sum()

    }

    fun solve2(): Long? {

        commandsToProcess.next()
        val root = Directory("/", ArrayList(), ArrayList(), null);
        buildDirTree(commandsToProcess.next(), root)

        val freeSpace = 70000000 - root.totalSize()
        val spaceToFree = 30000000 - freeSpace

        return root.getSizes().sorted().stream()
            .filter { size -> size >= spaceToFree }
            .findFirst()
            .orElse(null)
    }

    private fun buildDirTree(command: String, dir: Directory?): Unit {
        var updatedDir: Directory? = dir

        if (command.contains("$ cd ..")) {
            updatedDir = dir?.parent
        } else if (command.contains("dir ")) {
            dir?.addDir(Directory(command.split(" ").last(), ArrayList(), ArrayList(), dir))
        } else if (command.contains("$ cd ")) {
            updatedDir = dir?.findDirBy(command.split(" ").last())
        } else if (command.split(" ").first().all { char -> char.isDigit() }) {
            dir?.addFile(command.split(" ").first().toLong())
        }

        if (commandsToProcess.hasNext()) {
            buildDirTree(commandsToProcess.next(), updatedDir)
        }
    }


    class Directory(
        val name: String,
        var childDirs: MutableList<Directory>,
        var files: MutableList<Long>,
        var parent: Directory?
    ) {

        fun getDirsUnder(limit: Int): List<Long> {
            val allUnderLimit: MutableList<Long> = ArrayList()
            if (this.totalSize() < limit) {
                allUnderLimit.add(this.totalSize());
            }
            allUnderLimit.addAll(childDirs.flatMap { childDir -> childDir.getDirsUnder(limit) }.toList())
            return allUnderLimit;
        }

        fun getSizes(): MutableList<Long> {
            val all: MutableList<Long> = ArrayList()
            all.add(totalSize());
            all.addAll(childDirs.flatMap { childDir -> childDir.getSizes() }.toList())
            return all;
        }

        fun totalSize(): Long {
            return files.sum() + childDirs.stream().map { childDir -> childDir.totalSize() }.toList().sum()
        }

        fun addFile(file: Long): Unit {
            files.add(file)
        }

        fun addDir(dir: Directory): Unit {
            dir.parent = this
            childDirs.add(dir)
        }

        fun findDirBy(dirName: String): Directory {
            return childDirs.stream().filter { dir -> dir.name == dirName }.findAny().orElse(null)
        }

    }

}