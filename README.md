6.5830/6.5831 Labs
==================

Git repository for labs in [6.5830/6.5831](http://dsg.csail.mit.edu/6.5830/).

We will be using git, a source code control tool, to distribute labs in
6.5830/6.5831. This will allow you to incrementally download the code for the
labs, and for us to push any hot fixes that might be necessary.

You will also be able to use git to commit and backup your progress on the labs
as you go. Course git repositories will be hosted as a repository in GitHub, a
website that hosts runs git servers for thousands of open source projects. In
our case, your code will be in a private repository that is visible only to you
and course staff.

This document describes what you need to do to get started with git, and also
download and upload 6.5830/6.5831 labs via GitHub.

**If you are not a registered student at MIT, you are welcome to follow along,
but we ask you to please keep your solution PRIVATE and not make it
publicly available**

## Contents

- [Learning Git](#learning-git)
- [Setting up GitHub](#setting-up-github)
- [Installing Git](#installing-git)
- [Setting up Git](#setting-up-git)
- [Getting Newly Released Labs](#getting-newly-released-labs)
- [Submitting Labs](#submitting-labs)
- [Word of Caution](#word-of-caution)
- [Help!](#help)

## <a name="learning-git">Learning Git</a>

There are numerous guides on using Git that are available. They range from being interactive to just text-based. Find
one that works and experiment; making mistakes and fixing them is a great way to learn.
Github has compiled a list of such resources
[here][resources].

If you have no experience with git, you may find
this [Missing Semester lecture][missing-semester-version-control] helpful. And if you want to build an intuition with git commands, try this [card game][omg].

## <a name="setting-up-github">Setting Up GitHub</a>

Now that you have a basic understanding of Git, it's time to get started with GitHub.

0. Install git. (See below for suggestions).

1. If you don't already have an account, [sign up for one][join].

### <a name="installing-git">Installing git</a>

The instructions are tested on bash/linux environments. Installing git should be a simple `apt-get install`, `yum install`, or similar.

Instructions for installing git on Linux, OSX, or Windows can be found at
[GitBook:
Installing][gitbook].

If you are using an IDE like IntelliJ/VSCode, it likely comes with git integration. The set-up instructions below may be slightly different than the
command line instructions listed, but will work for any OS. Detailed instructions can be found
in
[IntelliJ Help][intellij-help],
[VSCode Version Control Guide][vscode-version-control],
and/or
[VSCode Github Guide][vscode-github].

## <a name="setting-up-git">Setting Up Git</a>

You should have Git installed from the previous section.

1. The first thing we have to do is to clone the current lab repository by issuing the following commands on the command line:

   ```bash
    $ git clone https://github.com/MIT-DB-Class/simple-db-hw-2022.git
   ```

   Now, every time a new lab or patch is released, you can

   ```bash
    $ git pull
   ```
   to get the latest. 
   
   That's it. You can start working on the labs! That said, we strongly encourage you to use git for more than just
   downloading the labs. In the rest of the guide we will walk you through on how to use git for version-control
   during your own development. 

2. Notice that you are cloning from our repo, which means that it will be inappropriate for you to push your code to it.
   If you want to use git for version control, you will need to create your own repo to write your changes to. Do so 
   by clicking 'New' on the left in github, and make sure to choose **Private** when creating, so others cannot see your
   code! Now we are going to change the repo we just checked out to point to your personal repository.

3. By default the remote called `origin` is set to the location that you cloned the repository from. You should see the following:

   ```bash
    $ git remote -v
        origin https://github.com/MIT-DB-Class/simple-db-hw-2022.git (fetch)
        origin https://github.com/MIT-DB-Class/simple-db-hw-2022.git (push)
   ```

   We don't want that remote to be the origin. Instead, we want to change it to point to your repository. To do that, issue the following command:

   ```bash
    $ git remote rename origin upstream
   ```

   And now you should see the following:

   ```bash
    $ git remote -v
        upstream https://github.com/MIT-DB-Class/simple-db-hw-2022.git (fetch)
        upstream https://github.com/MIT-DB-Class/simple-db-hw-2022.git (push)
   ```

4. Lastly we need to give your repository a new `origin` since it is lacking one. Issue the following command, substituting your athena username:

   ```bash
    $ git remote add origin https://github.com/[your-username]/[your-repo]
   ```

   If you have an error that looks like the following:

   ```
   Could not rename config section 'remote.[old name]' to 'remote.[new name]'
   ```

   Or this error:

   ```
   fatal: remote origin already exists.
   ```

   This appears to happen to some depending on the version of Git being used. To fix it, just issue the following command:

   ```bash
   $ git remote set-url origin https://github.com/[your-username]/[your-repo]
   ```

   This solution was found from [StackOverflow](http://stackoverflow.com/a/2432799) thanks to [Cassidy Williams](https://github.com/cassidoo).

   For reference, your final `git remote -v` should look like following when it's setup correctly:


   ```bash
    $ git remote -v
        upstream https://github.com/MIT-DB-Class/simple-db-hw-2022.git (fetch)
        upstream https://github.com/MIT-DB-Class/simple-db-hw-2022.git (push)
        origin https://github.com/[your-username]/[your-repo] (fetch)
        origin https://github.com/[your-username]/[your-repo] (push)
   ```

5. Let's test it out by doing a push of your main branch to GitHub by issuing the following:

   ```bash
    $ git push -u origin main
   ```

   You should see something like the following:

   ```
   Counting objects: 59, done.
   Delta compression using up to 4 threads.
   Compressing objects: 100% (53/53), done.
   Writing objects: 100% (59/59), 420.46 KiB | 0 bytes/s, done.
   Total 59 (delta 2), reused 59 (delta 2)
   remote: Resolving deltas: 100% (2/2), done.
   To git@github.com:[your-repo].git
    * [new branch]      main -> main
   Branch main set up to track remote branch main from origin.
   ```


6. That last command was a bit special and only needs to be run the first time to setup the remote tracking branches.
   Now we should be able to just run `git push` without the arguments. Try it and you should get the following:

   ```bash
    $ git push
      Everything up-to-date
   ```

If you don't know Git that well, this probably seemed very arcane. Just keep using Git and you'll understand more and
more. You aren't required to use commands like `commit` and `push` as you develop your labs, but will find them useful for
debugging. We'll provide explicit instructions on how to use these commands to actually upload your final lab solution.

## <a name="getting-newly-released-labs">Getting Newly Released Labs</a>

(You don't need to follow these instructions until Lab 1.)

Pulling in labs that are released or previous lab solutions should be easy as long as you set up your repository based
on the instructions in the last section.

1. All new lab and previous lab solutions will be posted to the [labs repository][labs-github] in the class organization.

   Check it periodically as well as Piazza's announcements for updates on when the new labs are released.

2. Once a lab is released, pull in the changes from your simpledb directory:

   ```bash
    $ git pull upstream main
   ```

   **OR** if you wish to be more explicit, you can `fetch` first and then `merge`:

   ```bash
    $ git fetch upstream
    $ git merge upstream/main
   ```
   Now commit to your main branch:
   ```bash
   $ git push origin main
   ```

3. If you've followed the instructions in each lab, you should have no merge conflicts and everything should be peachy.

## <a name="submitting-labs">Submitting Labs</a>

<!--
To submit your code, please create a <tt>6.830-lab1.tar.gz</tt> tarball (such
that, untarred, it creates a <tt>6.830-lab1/src/simpledb</tt> directory with
your code) and submit it on the [6.830 Stellar Site](https://stellar.mit.edu/S/course/6/sp13/6.830/index.html). You can use the `ant handin` target to generate the tarball.

TODO: make it possible to use `ant handin` with a zip file including the lab writeup
-->

We will be using Gradescope to autograde all labs. You should have all been
invited to the class instance; if not, please check Piazza for an invite code.
If you are still having trouble, let us know and we can help you get set up. You
may submit your code multiple times before the deadline; we will use the latest
version as determined by Gradescope. Place the write-up in a file called
`labN-writeup.txt` with your submission (with `N` replaced with the relevant lab
number).

The easiest way to submit to gradescope is with `.zip` files containing your
code. For example on Linux/macOS, you can submit lab 1 by running the following
command:

```bash
$ zip -r submission.zip src/ lab1-writeup.txt
```

## <a name="word-of-caution">Word of Caution</a>

Git is a distributed version control system. This means everything operates
*offline* until you run `git pull` or `git push`. This is a great feature.

However, one consequence of this is that you may forget to `git push` your
changes. This is why we **strongly** suggest that you check GitHub to be sure
that what you want to see matches up with what you expect.

## <a name="help">Help!</a>

If at any point you need help with setting all this up, feel free to reach out to one of the TAs or the instructor.
Their contact information can be found on the [course homepage](http://dsg.csail.mit.edu/6.5830/).

[gitbook]: http://git-scm.com/book/en/Getting-Started-Installing-Git

[intellij-help]: https://www.jetbrains.com/help/idea/version-control-integration.html

[join]: https://github.com/join

[labs-github]: https://github.com/MIT-DB-Class/simple-db-hw-2022

[missing-semester-version-control]: https://missing.csail.mit.edu/2020/version-control/

[omg]: https://ohmygit.org/

[resources]: https://help.github.com/articles/what-are-other-good-resources-for-learning-git-and-github

[ssh-key]: https://help.github.com/articles/generating-ssh-keys

[vscode-github]: https://code.visualstudio.com/docs/editor/github

[vscode-version-control]: https://code.visualstudio.com/Docs/editor/versioncontrol#_git-support
