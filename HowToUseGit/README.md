#Most useful commands

https://git-scm.com/book/en/v2

http://stackoverflow.com/questions/8196544/what-are-the-git-concepts-of-head-master-origin

https://www.youtube.com/watch?v=FyfwLX4HAxM&list=PLg7s6cbtAD15G8lNyoaYDuKZSKyJrgwB-

https://guides.github.com/activities/hello-world/


#How To Use Git / GitHub

<h4>Useful tips: </h4>
-<b> Git </b> it's a version control system and it works on your local PC <br>
-<b> GitHub </b> is a remote server. <br>
-<b> Simple Workflow on Local Repository </b> <br>

<img src="http://newtfire.org/dh/git_shell/gitWorkflow.jpg" width="320" height="188" />


<b><h3>Articles to read: </h3></b>
https://dev.to/gonedark/3-git-commands-i-use-every-day

<b><h3>List of useful commands:</h3></b>

```
  git init <project>
```

> Create an empty Git repository or reinitialize an existing one.

```
  git add <file or .>
```

> <b> git add * </b> means add all files in the current directory, except for files, whose name begin with a dot. This is your shell
> functionality, actually, Git only receives a list of files. <br>
> <b> git add . </b> though, has no special meaning in your shell, and Git add the entire directory recursively, which is basically the
> same, but it also adds files whose name begin with a dot.

```
  git clone <PathToRepository>
```

> Create a working copy of a local repository.

```
  git clone <username@host:/PathToRepository>
```

> Create a working copy of a remote repository.

```
  git commit -a -m "message"
```
> Add changes and commit them to the staging area. (add all tracked files not new ones)

```
  git status
```
> Shows Branch you are on. Shows untracked files. <br>
```
  git status -s
  git status --short
```
>> Shows a short-format output.

```
  git log
```
> Simply shows a commit logs.

```
  git diff
```
> Shows changes between commits. <br>
```
  git diff --cached
```
>> Shows the changes between the index and the HEAD(which is the last commit on this branch).
>> This shows what has been added to the index and staged for a commit.

```
  git branch
```
> Shows us a list of existing branches
```
  git branch <BranchName>
```
>> Creates new branch

```
  git checkout <BranchName>
```
> Switch branches

```
  git push origin master:master-1
```
> push changes and create new branch

```
  HEAD
```
> refers to last commit, on current branch or timeline we are on.

```
  git push -u origin master
```
> because of -u option we made origin as a default destination


``` git
  git branch -d nameOftheBranch
```
> just simply removes branch that we created

```
  git checkout -b branchName
```
> create and checkout branch
