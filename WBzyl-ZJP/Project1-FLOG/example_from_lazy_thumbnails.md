=begin

I. clone repository from github to local: 

  git clone https://github.com/tootsuite/mastodon.git


II. recursively check classes with FLOG for whole project: 

  find mastodon -name \*.rb | xargs flog > flogresults.txt


III. Explore the results to select classes to detail check: 

  81916.9: flog total
    10.4: flog/method average

  4097.0: main#none
  
  [...]
  
  70.6: Paperclip::LazyThumbnail#make    mastodon/lib/paperclip/lazy_thumbnail.rb:5-17
  
  [...]

IV. Use FLOG on selected class with --all --detailed parameters:

  flog -ad lazy_thumbnails.rb

  result: 

66.0: flog total
    66.0: flog/method average

    66.0: Paperclip::Thumbnail#make        example_from_lazy_thumbnails.rb:4-14
     9.7:   options
     9.2:   to_f
     8.1:   width
     6.6:   height
     6.4:   assignment
     6.3:   []
     5.5:   branch
     4.2:   /
     3.8:   to_i
     3.8:   *
     3.4:   sqrt
     3.0:   round
     1.4:   min
     1.3:   square?
     1.3:   <
     1.3:   path
     1.1:   open
     1.0:   needs_convert?

V. Connect metrics with specific functions / methods: 

=end

``` ruby

class Paperclip::Thumbnail                                                                                                          FLOG metrics:
  def make
    return File.open(@file.path) unless needs_convert?                                                                        # 1.1: open + 1.3: path + 1.0: needs_convert?

      if options[:geometry]                                                                                                   # 9.7: options + 6.3: []
        min_side = [@current_geometry.width, @current_geometry.height].min.to_i                                               # 8.1: width + 6.6: height + 9.2: to_f + 1.4: min + 3.8: to_i
        options[:geometry] = "#{min_side}x#{min_side}#" if @target_geometry.square? && min_side < @target_geometry.width      # 8.1: width / 6.6: height / 9.2: to_f
      elsif options[:pixels]                                                                                                  # 9.7: options
        width  = Math.sqrt(options[:pixels] * (@current_geometry.width.to_f / @current_geometry.height.to_f)).round.to_i      # 8.1: width  / 9.2: to_f
        height = Math.sqrt(options[:pixels] * (@current_geometry.height.to_f / @current_geometry.width.to_f)).round.to_i      # 6.6: height / 9.2: to_f
        options[:geometry] = "#{width}x#{height}>"
      end
  end
end

```



    